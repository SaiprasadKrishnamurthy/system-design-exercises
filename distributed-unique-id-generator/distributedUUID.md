## Algorithm: Twitter Snowflake ID approach

```
        ID:
            bit 1: 0 (always 0)
            next 41 bits: millis since custom epoch.
            next 5 bits: data center id.
            next 5 bits: machine id.
            next 12 bits: sequence no (per millisecond, resets every millis).
```

## Design:

```
    A counter approach which has a key:
        Key: 1_<epoch>_<dc_id>_<mc_id>_<millis>
        Value: seq
        OutputId: 1_<epoch>_<dc_id>_<mc_id>_<Value>
```

![Design](./distributed_id_generator.png?raw=true "Design")















