# JavaProjects(Java开发远程仓库接口)
##### 一、在命令行上创建新的存储库

示例：

```cmd
echo "# JavaProjects" >> README.md
git init
git add README.md
git commit -m "远程仓库接口"
git branch -M main
git remote add JavaProjects https://github.com/ynxiyan/JavaProjects.git
git push -u JavaProjects main
```

##### 二、从命令行推送现有存储库

示例：

```cmd
git remote add JavaProjects https://github.com/ynxiyan/JavaProjects.git
git branch -M main
git push -u JavaProjects main
```

##### 三、 远程仓别名的重命名

```cmd
git remote  -v // 查看远程仓
git remote rename trunk(现有远程仓别名)  private(自定义的远程仓别名) //  修改远程仓别名
git remote  // 将会显示 master(默认远程主仓别名) 和 private (自定义的个人仓别名)
```

##### 四、 删除远程仓

```cmd
git remote private // 删除远程仓
git remote // 只会显示master(默认远程主仓别名)
```
"# JavaProjects" 
"# JavaProjects" 
