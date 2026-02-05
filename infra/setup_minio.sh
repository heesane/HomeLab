#!/bin/bash
# Wait for MinIO to be ready
echo "Waiting for MinIO..."
sleep 5

# Run mc command using docker
docker run --rm --network homelab-network \
  --entrypoint /bin/sh \
  minio/mc -c "
    mc alias set myminio http://homelab-minio:9000 admin password;
    mc mb myminio/images;
    mc mb myminio/videos;
    mc anonymous set download myminio/images;
    mc anonymous set download myminio/videos;
  "

echo "MinIO buckets created."
