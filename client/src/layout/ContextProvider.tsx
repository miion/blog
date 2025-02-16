import { DrawerProvider } from "@/context/drawer"
import { ReactElement } from "react"

type ComponentProps = {
  children: ReactElement | ReactElement[]
}

const ContextProvider = ({ children }: ComponentProps) => {
  return <DrawerProvider>{children}</DrawerProvider>
}

export default ContextProvider
