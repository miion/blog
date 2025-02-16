import useChatMessageStore from "@/store/chat/chatStore"
import * as React from "react"

const MessageList = () => {
  const { messages } = useChatMessageStore()

  return (
    <div>
      {messages.map((it, index) => {
        return <div key={`messages_${index}`}>{it.text}</div>
      })}
    </div>
  )
}

export default MessageList
