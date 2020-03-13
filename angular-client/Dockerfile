FROM nginx
MAINTAINER Mario Hercog <mario.hercog@gmail.com>

COPY dist/angular-client /usr/share/nginx/html

EXPOSE 80

ENTRYPOINT ["nginx", "-g", "daemon off;"]
