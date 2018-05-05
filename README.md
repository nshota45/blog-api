build
```bash
sbt clean stage
```

```bash
./target/universal/stage/bin/blog-api -Dhttp.port=9000 -Dconfig.file=/home/nakano/blog-api/conf/production.conf
```