import { ErrorMessageMode } from "#/axios";
import { defHttp } from "@/utils/http/axios";

/**
 * @description: user login api
 */
export function login(params: any, mode: ErrorMessageMode = 'modal') {
  return defHttp.post<any>({url: "/admin/login", params,}, {errorMessageMode: mode,}
  );
}
