import { Route, Routes } from "react-router"
import { Spin } from "antd"
import loadable from "@loadable/component"
import { useMemo } from "react"
import menus from "@/routes/menu"
import pages from "@/routes/pages"

const HOME = import.meta.glob("/src/pages/index.tsx", { eager: true })

const HomeComponent = loadable(() => import("@/pages/_home"), {
  fallback: <Spin size="large" />,
})

const AsyncPage = loadable((props: { page: string }) => import(`${props.page}`), {
  fallback: <Spin size="large" />,
  cacheKey: (props) => props.page,
})

const BlogRoutes = () => {
  const routes = useMemo(() => {
    return [...menus, ...pages]
      .flatMap((it) => (it.children ? it.children : it))
      .filter((it) => it?.page)
      .map((route, index) => {
        return (
          <Route
            key={`route_${index}`}
            path={route?.url}
            element={<AsyncPage page={route?.page ?? ""} />}
          />
        )
      })
  }, [])

  return (
    <Routes>
      {routes}
      <Route path={"*"} element={<HomeComponent />} />
    </Routes>
  )
}

BlogRoutes.displayName = "Routes"
export default BlogRoutes
