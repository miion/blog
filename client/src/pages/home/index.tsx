import { useCurrentUser } from "@/modules/user/hooks/user"
import { Spin } from "antd"
import * as React from "react"
import PERMISSION from "@/infrastructure/constants/permission.constant"

const Home2 = () => {
  const { data, isPending } = useCurrentUser()

  if (isPending) {
    return <Spin />
  }

  return <div>{data}</div>
}

Home2.permission = PERMISSION.A

export default Home2
