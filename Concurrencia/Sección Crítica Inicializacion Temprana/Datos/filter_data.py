def create_files_by_prefix(input_file, prefixes):
    output_files = {}

    # Create output files for each prefix
    for prefix in prefixes:
        output_files[prefix] = open(f'{prefix}_output.txt', 'w')

    with open(input_file, 'r') as infile:
        for line in infile:
            for prefix in prefixes:
                if line.strip().startswith(prefix):
                    output_files[prefix].write(line)
                    break  # Break the loop if a match is found

    # Close all output files
    for file in output_files.values():
        file.close()



def remove_match_text_from_lines(input_file, output_file, text_to_remove):
    with open(input_file, 'r') as infile:
        lines = infile.readlines()

    with open(output_file, 'w') as outfile:
        for line in lines:
            modified_line = line.replace(text_to_remove, '')
            outfile.write(modified_line)

# Example usage
input_filename = 'tiempos_early.txt'  # Replace with your input file name
prefixes_to_select = ['Obtener']  # Replace with your prefixes

create_files_by_prefix(input_filename, prefixes_to_select)


input_filename = 'tiempos_early.txt'  # Replace with your input file name
prefixes_to_select = ['Escribir archivo']  # Replace with your prefixes

create_files_by_prefix(input_filename, prefixes_to_select)



# Example usage
input_filename = 'Obtener_output.txt'  # Replace with your input file name
output_filename = 'Obtener_no_names.txt'  # Replace with your desired output file name
text_to_remove = 'Obtener registrador: '  # Replace with the text you want to remove

remove_match_text_from_lines(input_filename, output_filename, text_to_remove)


input_filename = 'Escribir archivo_output.txt'  # Replace with your input file name
output_filename = 'Escribir archivo_no_names.txt'  # Replace with your desired output file name
text_to_remove = 'Escribir archivo: '  # Replace with the text you want to remove

remove_match_text_from_lines(input_filename, output_filename, text_to_remove)


#tranpose one column to 4 columns
import numpy as np

# Read data from a file
input_file_path = 'Obtener_no_names.txt'  # Replace with the path to your input file
output_file_path = 'final.csv'  # Replace with the desired path for the output file

with open(input_file_path, 'r') as file:
    lines = file.readlines()

# Convert the data to a NumPy array
single_column_data = np.array([float(line.strip()) for line in lines])

# Reshape the array to have 4 columns
transposed_data = single_column_data.reshape(-1, 4)

# Save the transposed data to a new file
with open(output_file_path, 'w') as output_file:
    for row in transposed_data:
        output_file.write(','.join(map(str, row)) + '\n')



# Average every 100 values 
input_file_path = 'Escribir archivo_no_names.txt'  # Replace with the path to your file

with open(input_file_path, 'r') as file:
    lines = file.readlines()

# Convert the data to a NumPy array
column_data = np.array([float(line.strip()) for line in lines])

# Reshape the array to create groups of 100 values
reshaped_data = column_data.reshape(-1, 100)

# Calculate the average of each group
averages = np.mean(reshaped_data, axis=1)

# Save the averages to a new file
output_file_path = 'averages_output.txt'  # Replace with the desired path for the output file

with open(output_file_path, 'w') as output_file:
    for average in averages:
        output_file.write(str(average) + '\n')



#tranpose one column to 4 columns second
# Read data from a file
input_file_path = 'averages_output.txt'  # Replace with the path to your input file
output_file_path = 'averages_transponse.csv'  # Replace with the desired path for the output file

with open(input_file_path, 'r') as file:
    lines = file.readlines()

# Convert the data to a NumPy array
single_column_data = np.array([float(line.strip()) for line in lines])

# Reshape the array to have 4 columns
transposed_data = single_column_data.reshape(-1, 4)

# Save the transposed data to a new file
with open(output_file_path, 'w') as output_file:
    for row in transposed_data:
        output_file.write(','.join(map(str, row)) + '\n')