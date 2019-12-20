#swagger2接口文档编写方法
[swagger hub](https://app.swaggerhub.com/apis/honins/yyw-hospital/1.0.0#/)

示例文件：
```
swagger: "2.0"
info:
  title: Sample API
  description: API description in Markdown.
  version: 1.0.0
host: api.example.com
schemes:
  - https
paths:
  /user/login:
    post:
      tags:
        - User
      summary: 登陆
      operationId: login
      parameters:
        - in: body
          name: loginParam
          required: true
          schema:
            $ref: '#/definitions/LoginParam'
      responses:
        '200':
          description: 'ok'
          schema:
            $ref: '#/definitions/TokenVO'
  /user/logout:
    post:
      tags:
        - User
      summary: 登出
      operationId: logout
      responses:
        '200':
          description: 'ok'
  /user/get:
    get:
      tags:
        - User
      summary: 获得用户信息
      operationId: getUserInfo
      parameters:
        - in: query
          name: role
          required: true
          type: string
      responses:
        '200':
          description: 'ok'
          schema:
            $ref: '#/definitions/UserVO'

  /user/qrcode/create:
    get:
      tags:
        - User
      summary: 创建二维码
      operationId: qrcode
      parameters:
        - in: query
          name: role
          type: string
          description: 角色
      responses:
        '200':
          description: ok
          schema:
            $ref: '#/definitions/QrcodeVO'


definitions:
  LoginParam:
    type: object
    required:
      - account
      - password
    properties:
      account:
        type: string
      password:
        type: string

  RoleParam:
    type: object
    required:
      - role
    properties:
      role:
        type: string

  TokenVO:
    type: object
    required:
      - token
      - createTime
    properties:
      token:
        type: string
      createTime:
        type: number

  UserVO:
    type: object
    required:
      - name
      - role
    properties:
      name:
        type: string
      role:
        type: string
  QrcodeVO:
    type: object
    required:
      - qrCodeUrl
    properties:
      qrCodeUrl:
        type: string

```
