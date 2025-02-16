import worker from "@/mocks/worker"
import queryClient from "@infra/query/queryClient"

if (import.meta.env.DEV) {
  worker.start({
    onUnhandledRequest: "bypass",
  })
  window.startMSW = () => {
    worker.start()
    queryClient.invalidateQueries()
  }
  window.stopMSW = () => {
    worker.stop()
    queryClient.invalidateQueries()
  }
}
