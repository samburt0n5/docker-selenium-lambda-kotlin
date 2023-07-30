### To run the demo

```bash
$ npm install -g serverless # skip this line if you have already installed Serverless Framework
$ export AWS_REGION=ap-northeast-1 # You can specify region or skip this line. eu-west-2 will be used by default.
$ ./mvnw compile dependency:copy-dependencies -DincludeScope=runtime
$ docker build --tag docker-selenium-lambda-kotlin .
$ sls deploy
$ sls invoke --function demo # Yay! You will get texts of example.com
```