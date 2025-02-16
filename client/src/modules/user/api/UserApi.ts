import apiClient from "@/infrastructure/http/apiClient"

export default class UserApi {
  public static findPermission() {
    return apiClient.get<string[]>({
      url: "/logins/users/permissions",
    })
  }
  public static findCurrentUser() {
    return apiClient.get<string | null>({
      url: "/logins/users",
    })
  }
}
