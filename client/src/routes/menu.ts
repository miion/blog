import PERMISSION from "@/infrastructure/constants/permission.constant"

export type MenuConfig = {
  key: string
  permission: string[]
  url: string
  page?: string
  children?: MenuConfig[]
}

const COMPONENT: Record<string, { [key: string]: any }> = import.meta.glob(
  "/src/pages/**/[a-z]*.tsx",
  { eager: true }
)
const components = Object.keys(COMPONENT).map((component) => {
  const path = component
    .replace(/\/src\/pages|index|\.tsx$/g, "")
    .replace(/\[\.{3}.+\]/, "*")
    .replace(/\[(.+)\]/, ":$1")

  const permission = COMPONENT[component].default.permission

  return {
    permission,
    path,
    component,
  }
})

const menus: MenuConfig[] = components.map((it) => {
  return {
    // key: PERMISSION.NONE,
    key: it.permission,
    permission: [],
    url: it.path,
    page: it.component,
  }
})

export default menus
