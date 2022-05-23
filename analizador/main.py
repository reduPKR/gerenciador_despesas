from kafka import KafkaConsumer

if __name__ == '__main__':
    consumer = KafkaConsumer(
        'CALCULAR_DESPESA',
        bootstrap_servers=['localhost:9092'],
        auto_offset_reset='earliest',
        enable_auto_commit=True,
        group_id='my-group'
        #value_deserializer=
    )

    print(consumer)