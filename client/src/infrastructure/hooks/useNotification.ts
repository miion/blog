import { useEffect } from "react"
import { notification } from "../app/globalApp"

const useNotification = () => {
  useEffect(() => {
    const eventSource = new EventSource("/api/subscribe")

    eventSource.addEventListener("new_thread", () => {
      //'new_thread' 이벤트가 오면 할 동작
    })
    eventSource.onmessage = (event) => {
      console.log(event)
      const data = JSON.parse(event.data)
      notification.info(data)
    }

    eventSource.onerror = () => {
      //에러 발생시 할 동작
      console.log("error")
      eventSource.close() //연결 끊기
    }

    eventSource.addEventListener("init", (event) => {
      console.log(event.data)
      notification.info(event.data)
    })
    eventSource.addEventListener("notification", (event) => {
      console.log(event.data)
      notification.info(event.data)
    })

    return () => {
      eventSource.close()
    }
  }, [])
}

export default useNotification
