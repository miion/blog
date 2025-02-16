import { setupWorker } from "msw/browser"
import handler from "./handlers"

export default setupWorker(...handler)
