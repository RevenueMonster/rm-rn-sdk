// #import "RevenueMonster.h"

// @implementation RevenueMonster

// RCT_EXPORT_MODULE()

// RCT_EXPORT_METHOD(sampleMethod:(NSString *)stringArgument numberParameter:(nonnull NSNumber *)numberArgument callback:(RCTResponseSenderBlock)callback)
// {
//     // TODO: Implement some real useful functionality
//     callback(@[[NSString stringWithFormat: @"numberArgument: %@ stringArgument: %@", numberArgument, stringArgument]]);
// }

// @end


// #import "RevenueMonster.h"
#import <React/RCTBridgeModule.h>

// @implementation RevenueMonster

// RCT_EXPORT_MODULE();

// RCT_EXPORT_METHOD(addEvent:(NSString *)name location:(NSString *)location)
// {
//   RCTLogInfo(@"Pretending to create an event %@ at %@", name, location);
// }

@interface RCT_EXTERN_MODULE(RevenueMonster, NSObject)

// RCT_EXTERN_METHOD(addEvent:(NSString *)name location:(NSString *)location date:(nonnull NSNumber *)date)

@end

// @end
