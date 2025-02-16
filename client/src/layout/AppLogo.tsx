import { Typography } from "antd"
import { FormattedMessage } from "react-intl"
import { Link } from "react-router"
import styled from "styled-components"

const { Text } = Typography

const Logo = styled.div`
  align-items: center;
  display: flex;
  column-gap: 8px;
`

const AppLogo = () => {
  return (
    <Link to={"/"}>
      <Logo>
        <Text style={{ color: "#ffffff", fontSize: "24px", fontWeight: "600 " }}>
          <FormattedMessage defaultMessage="Blog" />
        </Text>
      </Logo>
    </Link>
  )
}

AppLogo.displayName = "AppLogo"
export default AppLogo
