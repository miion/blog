import { create } from "zustand"

interface ChatMessage {
  text: String
  sender: String
}

interface ChatMessageState {
  messages: ChatMessage[]
  add: (by: ChatMessage) => void
}

const useChatMessageStore = create<ChatMessageState>((set) => ({
  messages: [],
  add: (by: ChatMessage) =>
    set((state: ChatMessageState) => {
      state.messages.push(by)
      return {
        messages: state.messages,
      }
    }),
}))

export default useChatMessageStore
