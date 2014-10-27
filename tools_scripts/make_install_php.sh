#!/bin/sh
brew install libjpeg
brew install libpng
brew install freetype

cd ~/Downloads/tools/php-5.6.1
./configure --prefix=/usr/local/php--mandir=/usr/share/man --infodir=/usr/share/info --with-apxs2=/usr/sbin/apxs--with-config-file-path=/usr/local/php/etc --enable-cli --with-curl --with-bz2--with-zlib --with-zlib-dir --with-mcrypt --enable-pdo --with-mysql=mysqlnd--with-mysqli=mysqlnd --with-pdo-mysql=mysqlnd --with-openssl --with-imap-ssl--enable-exif --enable-zip --enable-ftp --enable-soap --enable-sockets--with-curlwrappers --with-gettext --with-pear --enable-calendar--enable-mbstring --enable-bcmath --with-mhash --with-iconv-dir --with-libxml-dir--enable-safe-mode --enable-mbregex --enable-fpm --with-freetype-dir --with-gd--with-jpeg-dir --with-png-dir --with-xmlrpc --enable-gd-native-ttf--enable-xml --enable-sysvsem --enable-sqlite-utf8 --with-xsl--enable-zend-multibyte --with-pcre-regex --with-pgsql --with-pdo-pgsql

sudo make
sudo make install
