import { usePermission } from "@/modules/user/hooks/user"
import menus, { MenuConfig } from "@/routes/menu"
import menuNames from "@/routes/menu.lang"
import { useQueryClient } from "@tanstack/react-query"
import { Menu, MenuProps } from "antd"
import { useMemo } from "react"
import { FormattedMessage, MessageDescriptor } from "react-intl"
import { Link, useLocation } from "react-router"

type MenuItem = Required<MenuProps>["items"][number]

const getItem = (
  label: React.ReactNode,
  key: React.Key,
  children?: MenuItem[],
  type?: "group"
): MenuItem => {
  return {
    key,
    children,
    label,
    type,
  } as MenuItem
}

const extractMenuKey = (path: string): string[] => {
  for (const menu of menus) {
    for (const child of menu.children ?? []) {
      if (path === child.url) {
        return [menu.key, child.key]
      }
    }
  }
  return []
}

const createMenu = (
  menu: MenuConfig,
  permissions: Record<string, string>,
  last: boolean = false
): MenuItem => {
  const menuName: MessageDescriptor = menuNames[menu.key]
  const label = last ? (
    <Link to={menu.url}>
      <FormattedMessage {...menuName} />
    </Link>
  ) : (
    <FormattedMessage {...menuName} />
  )
  const children = menu.children
    ?.filter((child) =>
      child.permission.length == 0 || child.permission.includes("")
        ? true
        : child.permission.some((permission) => permissions[permission])
    )
    .map((child) => createMenu(child, permissions, true))
  return getItem(label, menu.key, children)
}

const BlogMenu = () => {
  const { data: permissions = {} } = usePermission()
  const queryClient = useQueryClient()
  const location = useLocation()

  const menuItems: MenuItem[] = useMemo(() => {
    return menus
      .filter((menu) =>
        menu.permission.length == 0 || menu.permission.includes("")
          ? true
          : menu.permission.some((permission) => permissions[permission])
      )
      .map((menu) => createMenu(menu, permissions, !menu.children))
  }, [permissions])

  return (
    <Menu
      mode={"inline"}
      defaultOpenKeys={extractMenuKey(location.pathname)}
      defaultSelectedKeys={extractMenuKey(location.pathname)}
      items={menuItems}
    />
  )
}

BlogMenu.displayName = "Menu"
export default BlogMenu
