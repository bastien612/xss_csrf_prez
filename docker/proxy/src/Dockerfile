FROM nginx:1.15.9-alpine

# RUN rm /var/log/nginx/access.log \
#     && rm /var/log/nginx/error.log

COPY nginx.conf /etc/nginx/nginx.conf
COPY dist /usr/share/nginx/html

# RUN addgroup -g 1000 -S www-data \
#     && adduser -u 1000 -D -S -G www-data www-data
# RUN chown -R www-data:www-data /usr/share/nginx/html
# USER www-data