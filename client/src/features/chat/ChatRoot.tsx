import useChatMessageStore from "@/store/chat/chatStore"
import { Button, Input } from "antd"
import { useEffect, useRef, useState } from "react"
import { Controller, SubmitHandler, useForm } from "react-hook-form"
import MessageList from "./MessageList"
import webSocketInstance from "@/infrastructure/websocket/websocketInstance"
import apiClient from "@/infrastructure/http/apiClient"

interface IFormInputs {
  text: string
}

const ChatRoot = () => {
  const { add } = useChatMessageStore()
  const webSocket = useRef<WebSocket | null>(null)

  useEffect(() => {
    webSocket.current = new WebSocket("http://localhost:8080/ws")
    webSocket.current.onopen = () => {
      console.log("WebSocket 연결!")
    }
    webSocket.current.onclose = (error) => {
      console.log(error)
    }
    webSocket.current.onerror = (error) => {
      console.log(error)
    }
    webSocket.current.onmessage = (event: MessageEvent) => {
      console.log(event.data)
      add(JSON.parse(event.data))
    }

    return () => {
      webSocket.current?.close()
    }
  }, [])

  const { handleSubmit, control, reset } = useForm<IFormInputs>({
    defaultValues: {
      text: "",
    },
  })
  const onSubmit: SubmitHandler<IFormInputs> = (data) => {
    console.log(data)
    if (!webSocket || !webSocket.current) {
      return
    }
    if (webSocket.current.readyState === WebSocket.OPEN) {
      webSocket.current.send(
        JSON.stringify({
          text: data.text,
          sender: "user1",
        })
      )
    }
  }

  const handleClick = () => {
    webSocketInstance.publish({
      destination: `/pub/alarm`,
    })
    apiClient.get({
      url: "/pub/alarm2",
    })
    console.log("hello")
  }

  return (
    <>
      <MessageList />
      <form onSubmit={handleSubmit(onSubmit)}>
        <Controller
          name="text"
          control={control}
          rules={{ required: "입력하세요." }}
          render={({ field }) => <Input {...field} placeholder="TEST을 입력해주세요." />}
        />
      </form>
      <Button onClick={handleClick} />
    </>
  )
}

export default ChatRoot
