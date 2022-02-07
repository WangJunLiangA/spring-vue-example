/*
 * @Description: 封装的网络请求
 * @Author: JunLiangWang
 * @Date: 2022-02-07 16:45:49
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-07 17:41:45
 */
import axios from 'axios'
//创建网络请求
  axios.defaults.withCredentials = true
function Create() {
  return axios.create({
    baseURL: "http://localhost:9085/",
    timeout: 10000,
    withCredentials: true
  });
}
export default {
  Get: function (url, data) {
    var get = Create();
    return get.get(url, {
      params: data
    });
  },
  TokenGet: function (url, data) {
    var tokenget = Create();
    //加上请求头
    tokenget.interceptors.request.use(function (config) {
      config.headers.Authorization = "Bearer:" + sessionStorage.getItem("token");
      return config;
    }, function (error) {
      return Promise.reject(error);
    });
    return tokenget.get(url, {
      params: data
    });
  },
  Post: function (url, data) {
    var post = Create();
    return post.post(url, data);
  },
  TokenPost: function (url, data) {
    var tokenpost = Create();
    tokenpost.interceptors.request.use(function (config) {
      config.headers.Authorization = "Bearer:" + sessionStorage.getItem("token");
      return config;
    }, function (error) {
      return Promise.reject(error);
    });
    return tokenpost.post(url, data);
  },
  TokenPostUpFile: function (url, form, callback = function () {}) {
    var tokenpost = Create();
    return tokenpost.post(url, form, {
      headers: {
        'Authorization': "Bearer:" + sessionStorage.getItem("token"),
        'Content-Type': 'multipart/form-data',
      },
      timeout: 60000,
      withCredentials: true,
      onUploadProgress: progressEvent => {
        callback((progressEvent.loaded / progressEvent.total * 100 | 0) * 1)
      }
    });
  }
}