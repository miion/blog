import { lazy, Suspense, useEffect } from "react"
import queryClient from "@infra/query/queryClient"
import { ReactQueryDevtools } from "@tanstack/react-query-devtools"
import { QueryClientProvider } from "@tanstack/react-query"
import { useBoolean } from "usehooks-ts"
import Layout from "./layout/Layout"
import webSocketInstance from "./infrastructure/websocket/websocketInstance"
import useNotification from "./infrastructure/hooks/useNotification"

const ReactQueryDevtoolsProduction = lazy(() =>
  import("@tanstack/react-query-devtools/build/modern/production.js").then((d) => ({
    default: d.ReactQueryDevtools,
  }))
)

function App() {
  const { value: showDevtools, toggle: toggleShowDevtools } = useBoolean(false)

  useEffect(() => {
    window.toggleDevtools = () => toggleShowDevtools()
    webSocketInstance.connect()
  }, [])

  useNotification()

  return (
    <QueryClientProvider client={queryClient}>
      <ReactQueryDevtools initialIsOpen={false} />
      {showDevtools && (
        <Suspense fallback={null}>
          <ReactQueryDevtoolsProduction />
        </Suspense>
      )}
      <Layout />
    </QueryClientProvider>
  )
}

export default App
