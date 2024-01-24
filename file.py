import random
import string

def generate_password(length=12, use_uppercase=True, use_digits=True, use_special_chars=True):
    characters = string.ascii_lowercase
    if use_uppercase:
        characters += string.ascii_uppercase
    if use_digits:
        characters += string.digits
    if use_special_chars:
        characters += string.punctuation
    if len(characters) == 0:
        print("Error: No character set selected.")
        return None

    password = ''.join(random.choice(characters) for _ in range(length))
    return password

if __name__ == "__main__":
    length = int(input("Enter the desired password length: "))
    use_uppercase = input("Include uppercase letters? (y/n): ").lower() == 'y'
    use_digits = input("Include digits? (y/n): ").lower() == 'y'
    use_special_chars = input("Include special characters? (y/n): ").lower() == 'y'

    password = generate_password(length, use_uppercase, use_digits, use_special_chars)

    if password:
        print(f"Generated Password: {password}")
