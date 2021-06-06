# 官方镜像
docker pull gitlab/gitlab-ce
# 中文镜像
docker pull beginor/gitlab-ce:11.3.0-ce.0

# 运行
docker run -d \
    -p 8443:443 -p 9003:9003 -p 222:22 \
    --name changqing_gitlab --restart always \
    -v /data/docker-data/gitlab/config:/etc/gitlab \
    -v /data/docker-data/gitlab/logs:/var/log/gitlab \
    -v /data/docker-data/gitlab/data:/var/opt/gitlab \
    --privileged=true beginor/gitlab-ce:11.3.0-ce.0

    
# 修改配置    
vim /data/docker-data/gitlab/config/gitlab.rb  
```
# 配置http协议所使用的访问地址,不加端口号默认为80
external_url 'http://106.53.26.9:9003'

# 配置ssh协议所使用的访问地址和端口
gitlab_rails['gitlab_ssh_host'] = '106.53.26.9'
gitlab_rails['gitlab_shell_ssh_port'] = 222
gitlab_rails['time_zone'] = 'Asia/Shanghai'

unicorn['worker_processes'] = 2
unicorn['worker_memory_limit_min'] = "200 * 1 << 20"
unicorn['worker_memory_limit_max'] = "300 * 1 << 20" 

### Email Settings
gitlab_rails['smtp_enable'] = true # 开启 SMTP 功能
gitlab_rails['smtp_address'] = "smtp.sina.com"
gitlab_rails['smtp_port'] = 465  # sina 和 qq 都要配置 465 其他的不行
gitlab_rails['smtp_user_name'] = "xxx@sina.com" # 你的邮箱账号
gitlab_rails['smtp_password'] = "xxx" # 授权码，不是密码
gitlab_rails['smtp_authentication'] = "login"
gitlab_rails['smtp_enable_starttls_auto'] = true
gitlab_rails['smtp_tls'] = true
gitlab_rails['gitlab_email_from'] = 'xxx@sina.com' # 发件人信息，必须跟‘smtp_user_name’保持一致，否则报错
gitlab_rails['smtp_domain'] = "sina.com" # 修改并不影响 
```

参考：http://help.sina.com.cn/comquestiondetail/view/160/
