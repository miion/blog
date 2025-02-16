import { Header } from "antd/es/layout/layout"
import AppLogo from "./AppLogo"
import CountrySelect from "./CountrySelect"

const BlogHeader = () => {
  return (
    <Header style={{ display: "flex", alignItems: "center", justifyContent: "space-between" }}>
      <AppLogo />
      <CountrySelect />
    </Header>
  )
}

BlogHeader.displayName = "Header"
export default BlogHeader
