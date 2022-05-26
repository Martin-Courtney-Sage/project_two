class Users:
    def __init__(self, user_id=0, first_name='', last_name='', email='', phone=''):
        self.user_id = user_id
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.phone = phone

    def __repr__(self):
        return str({
            'user_id': self.user_id,
            'first_name': self.first_name,
            'last_name': self.last_name,
            'email': self.email,
            'phone': self.phone
        })

    def __eq__(self, other):
        if other == None:
            return False
        else:
            return self.__dict__ == other.__dict__

    def json(self):
        return str({
            'userId': self.user_id,
            'firstName': self.first_name,
            'lastName': self.last_name,
            'email': self.email,
            'phone': self.phone
        })