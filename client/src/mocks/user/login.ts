import { delay, http, HttpResponse } from "msw"

export const userMock = "mion"

export const loginHandlers = [
  http.get("/api/logins/users", async () => {
    await delay(1000)
    return HttpResponse.json(userMock)
  }),
]
