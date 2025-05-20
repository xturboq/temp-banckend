# 温度监控系统

这是一个简单的温度监控系统，用于展示温度数据。

## 项目功能
- 展示温度数据
- 实时监控温度变化

## 技术栈
- 后端：Spring Boot
- 数据库：MySQL
- 前端：
  - Vue 3
  - Ant Design Vue
  - Axios
  - Pinia

## 项目结构
```
src/
  ├── main/
  │   ├── java/
  │   │   └── com/
  │   │       └── temperature/
  │   │           ├── controller/    # 控制器层
  │   │           ├── service/       # 服务层
  │   │           ├── repository/    # 数据访问层
  │   │           ├── model/         # 数据模型
  │   │           └── config/        # 配置类
  │   └── resources/
  │       └── application.properties # 配置文件
```

## 前端结构
```
frontend/
  ├── src/
  │   ├── api/           # API 请求
  │   ├── assets/        # 静态资源
  │   ├── components/    # 公共组件
  │   ├── router/        # 路由配置
  │   ├── stores/        # Pinia 状态管理
  │   ├── views/         # 页面组件
  │   ├── App.vue        # 根组件
  │   └── main.js        # 入口文件
  ├── package.json       # 项目依赖
  └── vite.config.js     # Vite 配置
```

## 数据模型
### 温度数据 (Temperature)
- id: 主键
- value: 温度值
- timestamp: 记录时间
- location: 位置信息（可选）

## API 接口
1. 获取温度数据
   - GET /api/temperature
   - 返回最新的温度数据

2. 获取历史温度数据
   - GET /api/temperature/history
   - 返回指定时间范围内的温度数据

## 开发规范
1. 代码规范
   - 遵循 Java 代码规范
   - 使用统一的代码格式化工具
   - 添加适当的注释
   - 前端遵循 Vue 3 组合式 API 规范
   - 使用 ESLint 和 Prettier 进行代码格式化

2. 提交规范
   - 使用清晰的提交信息
   - 每个功能独立分支开发

3. 文档规范
   - 及时更新文档
   - API 接口文档完整