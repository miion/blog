import { Button, Result } from "antd"
import React, { useCallback } from "react"
import { FormattedMessage } from "react-intl"
import styled from "styled-components"
import { ErrorBoundary } from "react-error-boundary"

type ComponentProps = {
  children: React.ReactElement | React.ReactElement[]
  message?: string
}

const CenterLayout = styled.div`
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
`

const Content = () => {
  const handleReload = useCallback(() => {
    window.location.reload()
  }, [])

  return (
    <CenterLayout>
      <Result
        status="error"
        title={<FormattedMessage defaultMessage="예기치 못한 오류가 발생했습니다." />}
        extra={
          <Button type="primary" onClick={handleReload}>
            <FormattedMessage defaultMessage="새로고침" />
          </Button>
        }
      />
    </CenterLayout>
  )
}

const BlogErrorBoundary = (props: ComponentProps) => {
  return <ErrorBoundary fallbackRender={Content}>{props.children}</ErrorBoundary>
}

BlogErrorBoundary.displayName = "ErrorBoundary"
export default BlogErrorBoundary
