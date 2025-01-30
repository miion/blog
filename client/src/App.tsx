import { lazy, Suspense, useEffect } from 'react'
import queryClient from '@infra/query/queryClient'
import { ReactQueryDevtools } from '@tanstack/react-query-devtools'
import { QueryClientProvider } from '@tanstack/react-query'
import { useBoolean } from 'usehooks-ts'

const ReactQueryDevtoolsProduction = lazy(() =>
  import("@tanstack/react-query-devtools/build/modern/production.js").then((d) => ({
    default: d.ReactQueryDevtools,
  }))
)

function App() {
  const { showDevtools, toggleShowDevtools } = useBoolean(false)

  useEffect(() => {
    window.toggleDevtools = () => toggleShowDevtools()
  }, [])

  return (
    <QueryClientProvider client={queryClient}>
      <ReactQueryDevtools initialIsOpen={false} />
      <div>
        Hello
      </div>
    </QueryClientProvider>
  )
}

export default App
