ls
ls -al
sudo ufw disable
sudo ufw status
tty
who
ifconfig
date
who
sudo apt install -y docker
sudo apt install -y docker.io
sudo apt-get install rdate
sudo rdate -p time.bora.net
sudo rdate -s time.bora.net
date
sudo apt-get install -y ntp
sudo vi /etc/ntp.conf 
sudo systemctl restart ntp
sudo systemctl status ntp
date
sudo vi /etc/ntp.conf 
sudo systemctl restart ntp
sudo systemctl status ntp
date
sudo systemctl enable ntp
date
sudo systemctl restart ntp
sudo systemctl status ntp
date
sudo ntpq -p
sudo vi /etc/ntp.conf 
sudo systemctl restart ntp
ntpq -p
date
sudo vi /etc/ntp.conf 
sudo systemctl restart ntp
sudo systemctl status ntp
ntpq -p
date
reboot
sudo reboot
sudo timedatectl set-timezone Asia/Seoul
date
history
Csudo vi /etc/ntp.conf
sudo vi /etc/ntp.conf
who
is
uname -a
cat /etc/*release
sudo hostnamectl set-hostname ottproj
hostname
ls
ls a-l
ls -al
sudo cat /etc/group
sudo reboot
whoami
ls
docker ps =a
docker ps -a
docker images
vi init.sql
ls
mv init.sql data.sql
ls
vi data.sql 
vi Dockerfile 
docker exec -it ott-app ping mysql-server
docker logs ott-app
docker ps
ls
tree
app/
cd app/
vi application.yml
cd ..
vi ./db/Dockerfile
vi docker-compose.yml
vi ./app/Dockerfile
clear
docker pull openjdk:17
tree
docker run --name ott-backend -d -p 8080:8080 openjdk:17
jar tf build/libs/app-0.0.1-SNAPSHOT.jar | grep images
docker build -t ott-app:v1.1 .
ls
tree
cd ./app
docker build -t ott-app:v1.1 .
cd ..
vi docker-compose.yml
docker-compose up
docker-compose down --volumes --remove-orphans
docker system prune -af
docker-compose up --build -d
docker-compose up
