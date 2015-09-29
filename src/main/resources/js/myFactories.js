var seqUser = 1;
var seqAdmin = 1;

var FacUser = Factory.define('user')
					.sequence('id', function(){
						return seqUser++;
					})
					.attr('name', function() { 
							return window.faker.name.findName(); 
					})
					.attr('crateDate', new Date());


Factory.define('admin')
						.extend('user')
						.sequence('id', function(){
											return seqAdmin++;
										}
						)
						.attr('admin', true);

Factory.define('book')
                        .attr('name', 'O dia do Coringa')
                        .attr('author', Factory.build('user'));
                        
print('\nUSER');
print(JSON.stringify(Factory.build('user')));

print('\nUSER LIST');
print(JSON.stringify(Factory.buildList('user', 15), null , ' '));

print('\nADMIN');
print(JSON.stringify(Factory.build('admin'), null, ' '));

print('\nBook');
print(JSON.stringify(Factory.build('book'), null, ' '));
