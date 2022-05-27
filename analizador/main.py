import json

from kafka import KafkaConsumer

if __name__ == '__main__':
    print("iniciou")

    consumer = KafkaConsumer('CALCULAR_DESPESA',
                                 bootstrap_servers=['192.168.0.4:9092'],
                                 group_id=None,
                                 auto_offset_reset='latest',
                                 value_deserializer=json.loads,
                                 api_version=(0, 10))

    for message in consumer:
        print("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                             message.offset, message.key,
                                             message.value))