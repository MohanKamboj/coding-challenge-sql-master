# SQl Master processing

# I have crteate the structure , but its not in running phase

### _Pre Requisites java11 and maven_

## My Approach for this implemnetation
    - to make it generic we have made Map with meta data Map<fileName, List<headers>>
    - for data we are using Map<fileName , <Map<headerName , dataValue>>>
    - how to the order by work 
    - user send command by Query <columnname>
    - we are validating the cloumn name from metadata if not exist INVValid column name Exception thrown 
    - When name found then we will get data from dataMap and do ordering of the data.
    - when user send the 2 cloumn name we will join those column data and revert the result back.

- Run main class from Main.java
- it will give open console to enter command 
- Below are the command that 
    - Query Columnname


