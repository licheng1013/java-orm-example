import { ErrorMessageMode } from "#/axios";
import { defHttp } from "@/utils/http/axios";

/**
 * @description: user login api
 */
export function login(params: any, mode: ErrorMessageMode = 'modal') {
  return defHttp.post<any>({url: "/admin/login", params,}, {errorMessageMode: mode,}
  );
}


export function adminUserinfo(params: any) {
  return defHttp.get<any>({url: "/admin/userInfo", params,}
  );
}
