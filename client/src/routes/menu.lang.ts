import PERMISSION from "@/infrastructure/constants/permission.constant"
import { defineMessages, MessageDescriptor } from "react-intl"

const menuNames: Record<string, MessageDescriptor> = defineMessages({
  [PERMISSION.NONE]: {
    description: "abc",
    defaultMessage: "zz",
  },
  [PERMISSION.CHAT]: {
    description: "chat",
    defaultMessage: "Chat",
  },
  [PERMISSION.A]: {
    description: "abc",
    defaultMessage: "A",
  },
  [PERMISSION.B]: {
    description: "abc",
    defaultMessage: "B",
  },
  [PERMISSION.NOTIFICATION]: {
    description: "notification",
    defaultMessage: "Notification",
  },
})

export default menuNames
