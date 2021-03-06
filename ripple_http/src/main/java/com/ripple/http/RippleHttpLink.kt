package com.ripple.http

import com.ripple.http.base.IRequestParams
import com.ripple.http.callback.OnHttpResult
import com.ripple.http.impl.HttpTask

/**
 * Author: fanyafeng
 * Data: 2020/8/10 10:16
 * Email: fanyafeng@live.cn
 * Description:
 *
 *
 * ------------
 * |           |
 * |           |
 * | post/get  |
 * |           |
 * |           |
 * -------------
 *       |
 *       |
 *       |  then
 *       |
 *       |
 * -------------                   --------------                   --------------                   --------------
 * |            |                  |             |                  |             |                  |             |
 * |            |       with       |             |        with      |             |      with        |             |
 * |  post/get  | -----------------|  post/get   | -----------------|  post/get   | -----------------|   post/get  |
 * |            |                  |             |                  |             |                  |             |
 * |            |                  |             |                  |             |                  |             |
 * --------------                  ---------------                  ---------------                  ---------------
 *                                                                                                         |
 *                                                                                                         |
 *                                                                                                         |  then
 *                                                                                                         |
 *                                                                                                         |
 *                                                                                                   -------------
 *                                                                                                   |            |
 *                                                                                                   |            |
 *                                                                                                   |  post/get  |
 *                                                                                                   |            |
 *                                                                                                   |            |
 *                                                                                                   --------------
 *                                                                                                         |
 *                                                                                                         |
 *                                                                                                         |  then
 *                                                                                                         |
 *                                                                                                         |
 *                                                                                                   -------------
 *                                                                                                   |            |
 *                                                                                                   |            |
 *                                                                                                   | post/get   |
 *                                                                                                   |            |
 *                                                                                                   |            |
 *                                                                                                   --------------
 *
 */
class RippleHttpLink internal constructor(private val httpTask: HttpTask) {

    /**
     * ????????????get??????
     *
     */
    fun <T> withGet(
        params: IRequestParams.IHttpRequestParams,
        callback: OnHttpResult<T>
    ): RippleHttpLink {
        httpTask.withGet(params, callback)
        return this
    }

    /**
     * ????????????????????????
     * ????????????get??????
     */
    fun <T> thenGet(
        params: IRequestParams.IHttpRequestParams,
        callback: OnHttpResult<T>
    ): RippleHttpLink {
        httpTask.thenGet(params, callback)
        return this
    }

    /**
     * ????????????post??????
     */
    fun <T> withPost(
        params: IRequestParams.IHttpRequestParams,
        callback: OnHttpResult<T>
    ): RippleHttpLink {
        httpTask.withPost(params, callback)
        return this
    }

    /**
     * ????????????????????????????????????post??????
     */
    fun <T> thenPost(
        params: IRequestParams.IHttpRequestParams,
        callback: OnHttpResult<T>
    ): RippleHttpLink {
        httpTask.thenPost(params, callback)
        return this
    }


    /**
     * .thenPost or .thenGet?????????????????????
     * .withPost or .withGet?????????????????????
     */
    fun start() {
        httpTask.start()
    }

}