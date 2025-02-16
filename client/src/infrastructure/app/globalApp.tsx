import { App } from "antd"
import { MessageInstance } from "antd/es/message/interface"
import { ModalStaticFunctions } from "antd/es/modal/confirm"
import { NotificationInstance } from "antd/es/notification/interface"

let message: MessageInstance
let notification: NotificationInstance
let modal: Omit<ModalStaticFunctions, "warn">

const GlobalApp = () => {
  const staticFunction = App.useApp()
  message = staticFunction.message
  modal = staticFunction.modal
  notification = staticFunction.notification
  return null
}

export default GlobalApp

export { message, modal, notification }
