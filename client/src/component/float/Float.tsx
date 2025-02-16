import { BugOutlined, QuestionCircleOutlined } from "@ant-design/icons"
import { FloatButton } from "antd"
import { FormattedMessage } from "react-intl"

const Float = () => {
  return (
    <FloatButton.Group shape="square" style={{ right: 60 }}>
      <FloatButton
        icon={<BugOutlined />}
        tooltip={<FormattedMessage defaultMessage="버그 리포팅" />}
      />
      <FloatButton
        icon={<QuestionCircleOutlined />}
        tooltip={<FormattedMessage defaultMessage="버그 리포팅" />}
      />
    </FloatButton.Group>
  )
}

export default Float
