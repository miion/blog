import { createQueryKeys } from "@lukemorales/query-key-factory"
import { useQuery } from "@tanstack/react-query"
import UserApi from "../api/UserApi"
import { associateBy } from "@/utility/arrayHelper"

export const permissionsKeys = createQueryKeys("permissions", {
  all: null,
})

export const usePermission = () => {
  return useQuery({
    queryKey: permissionsKeys.all.queryKey,
    queryFn: UserApi.findPermission,
    select: (data) => associateBy(data, (it: string | number) => it),
  })
}

export const loginUserKeys = createQueryKeys("loginUsers", {
  all: null,
})

export const useCurrentUser = () => {
  return useQuery({
    queryKey: loginUserKeys.all.queryKey,
    queryFn: UserApi.findCurrentUser,
  })
}
