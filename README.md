### To run the demo

```bash
$ npm install -g serverless # or if you don't want to install npm run 'curl -o- -L https://slss.io/install | bash' . Skip this line if you have already installed Serverless Framework
$ export AWS_REGION=ap-northeast-1 # You can specify region or skip this line. eu-west-2 will be used by default.
$ ./gradlew build
$ docker build --tag docker-selenium-lambda-kotlin .
$ sls deploy
$ sls invoke --function demo # Yay! You will get texts of example.com
```
