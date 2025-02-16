import SockJS from "sockjs-client"
import { Client, IPublishParams, StompSubscription } from "@stomp/stompjs"
import { notification } from "../app/globalApp"

interface SocketMessageDto {
  text: string
  sender: string
  type: string
}

export class WebSocketService {
  private client: Client
  private connected: boolean = false // 연결 여부

  constructor() {
    this.client = new Client({
      // 프로젝트의 end-point에 따라 url 설정
      // webSocketFactory: () => new SockJS("http://localhost:8080/ws-stomp"),
      webSocketFactory: () => new SockJS("/ws-stomp"),
      // 연결 성공시
      onConnect: () => {
        this.connected = true
        this.subscribeToNotifications()
        console.log("STOMP 연결 성공")
      },

      // 연결 실패시
      onDisconnect: () => {
        this.connected = false
      },
    })

    // 연결 에러 핸들링
    this.client.onStompError = (err) => {
      console.error("STOMP 에러 : ", err)
    }
  }

  private subscribeToNotifications(): void {
    // this.client.subscribe("/sub/message", (message) => {
    //   console.log(message)

    //   // 알림, 채팅 데이터가 있을 경우 JSON 파싱
    //   if (message.body) {
    //     const response: SocketMessageDto = JSON.parse(message.body)
    //     console.log(response)
    //   }
    // })
    this.client.subscribe("/sub/alarm", (message) => {
      console.log(message)
      if (message.body) {
        const response: SocketMessageDto = JSON.parse(message.body)
        notification.info({
          message: response.text,
          description: response.sender,
          placement: "topRight",
        })
      }
    })
  }

  publish(params: IPublishParams) {
    console.log(params)
    this.client.publish(params)
  }

  public setToken(token: string): void {
    this.client.configure({
      connectHeaders: {
        Authorization: token,
      },
    })
  }

  public connect(): void {
    if (!this.connected) {
      this.client.activate()
    }
  }

  public disconnect(): void {
    if (this.connected) {
      this.client.deactivate()
    }
  }
}
