FROM gitpod/workspace-full

COPY run.sh /app/run.sh
RUN wget -O /app/apktool.jar https://bitbucket.org/iBotPeaches/apktool/downloads/apktool_2.4.1.jar
CMD ["/app/run.sh"]
