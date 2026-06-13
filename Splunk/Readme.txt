#Start Splunk
docker compose up -d

#Stop Splunk
docker compose down

# Restart Splunk
docker compose restart

#View logs
docker logs -f splunk

# Remove everything (including volumes)
docker compose down -v