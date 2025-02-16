import { getCurrentLocale } from "@/infrastructure/i18n/i18n"
import { App, ConfigProvider, Layout } from "antd"
import Sider from "antd/es/layout/Sider"
import Header from "./Header"
import ErrorBoundary from "@/component/error/ErrorBoundary"
import ContextProvider from "./ContextProvider"
import { Content } from "antd/es/layout/layout"
import GlobalApp from "@/infrastructure/app/globalApp"
import Float from "@/component/float/Float"
import Routes from "./Routes"
import Menu from "./Menu"
import { BrowserRouter } from "react-router"

const BlogLayout = () => {
  return (
    <BrowserRouter>
      <ConfigProvider locale={getCurrentLocale()}>
        <Layout style={{ minHeight: "100vh" }}>
          <ErrorBoundary>
            <ContextProvider>
              <Header />
              <Layout>
                <Sider>
                  <Menu />
                </Sider>
                <Content style={{ padding: "24px" }}>
                  <App>
                    <GlobalApp />
                    <Routes />
                    <Float />
                  </App>
                </Content>
              </Layout>
            </ContextProvider>
          </ErrorBoundary>
        </Layout>
      </ConfigProvider>
    </BrowserRouter>
  )
}

BlogLayout.displayName = "Layout"
export default BlogLayout
