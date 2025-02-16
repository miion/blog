import React from "react"
import { ReactElement, useState } from "react"

const initialState = {}

export type DrawerTarget = ""

export const DrawerContext = React.createContext({
  status: initialState,
  setStatus: (status: Record<DrawerTarget, boolean>) => {},
})

type DrawerProviderProps = {
  children: ReactElement | ReactElement[]
}

export const DrawerProvider = ({ children }: DrawerProviderProps) => {
  const [status, setStatus] = useState(initialState)

  return <DrawerContext.Provider value={{ status, setStatus }}>{children}</DrawerContext.Provider>
}
