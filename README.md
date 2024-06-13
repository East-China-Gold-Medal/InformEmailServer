## 功能说明

- 提供了发送垃圾邮件的功能

- 提供了5个模板可供选择

- 使用前请先至`src/main/resources/application.yml`将发件邮箱配置好，经测试tx系邮箱可用，其他邮箱自行调试

## 接口说明

**POST**   /sendEmail

> Body 请求实例

```json
{
  "recipient": "example@foxmail.com",
  "title": "Mjhbuiiuoj Gqfpddi Gerdua",
  "content": "ticvwevq"
}
```

### 请求参数

| 名称        | 位置 | 类型   | 必选 | 说明 |
| ----------- | ---- | ------ | ---- | ---- |
| body        | body | object | 否   | none |
| » recipient | body | string | 是   | none |
| » title     | body | string | 是   | none |
| » content   | body | string | 是   | none |

> 返回示例

```json
{
  "code": 200,
  "message": "操作成功",
  "data": null
}
```

### 返回结果

| 状态码 | 状态码含义                                              | 说明 | 数据模型 |
| ------ | ------------------------------------------------------- | ---- | -------- |
| 200    | [OK](https://tools.ietf.org/html/rfc7231#section-6.3.1) | 成功 | Inline   |