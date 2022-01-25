/*
 * @Author: WangJunLiang 
 * @Date: 2022-01-25 10:04:15 
 * @Last Modified by: WangJunLiang
 * @Last Modified time: 2022-01-25 10:04:48
 * @工具类
 */
export default
{
    /**
    * 检测是否手机设备
    * @returns 
    */
    isMobile() {
        let flag = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i)
        return flag;
      }
}