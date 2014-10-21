#!/bin/bash
sudo -i
cd /var/log/mysql
rm mysql-slow.log

nmon -fT -s 1 -c 72000

